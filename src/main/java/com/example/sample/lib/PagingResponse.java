package com.example.sample.lib;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"rawtypes", "unchecked"})
public class PagingResponse<T> {
    private Paging paging;
    private List<T> data;

    public PagingResponse(Page page) {
		this.paging = new Paging(page);
		this.data = page.getContent();
	}
}
