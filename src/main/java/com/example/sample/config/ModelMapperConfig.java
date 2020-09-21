package com.example.sample.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;

import com.example.sample.utils.ModelMapperUtil;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Condition;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@PersistenceContext
	private EntityManager entityManager;

	@Bean
	public ModelMapper modelMapper() {
        ModelMapper modelMapper = ModelMapperUtil.MODEL_MAPPER;

		PersistenceUnitUtil puu = entityManager.getEntityManagerFactory().getPersistenceUnitUtil();

		modelMapper.getConfiguration()
		.setPropertyCondition(new Condition<Object, Object>() {
			@Override
			//lazy loading 무시용 조건
			public boolean applies(MappingContext<Object, Object> context) {
				return puu.isLoaded(context.getSource());
			}
		})
		.setMatchingStrategy(MatchingStrategies.STRICT);

		Provider<LocalDateTime> localDateTimeProvider = new AbstractProvider<LocalDateTime>() {
			@Override
			protected LocalDateTime get() {
				return LocalDateTime.now();
			}
		};

		Converter<Long, LocalDateTime> longToLocalDateTime = new AbstractConverter<Long, LocalDateTime>() {
			@Override
			protected LocalDateTime convert(Long source) {
				Instant instant = Instant.ofEpochMilli(source);
				return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
			}
		};

		modelMapper.createTypeMap(Long.class, LocalDateTime.class);
		modelMapper.addConverter(longToLocalDateTime);
		modelMapper.getTypeMap(Long.class, LocalDateTime.class).setProvider(localDateTimeProvider);

		return modelMapper;
	}
}
