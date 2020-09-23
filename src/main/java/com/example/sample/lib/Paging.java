package com.example.sample.lib;

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
@SuppressWarnings("rawtypes")
public class Paging {
    
    private Integer page;
    private Integer size;
    private Integer totalCount;
    private Integer totalPage;

    public Paging(Page page) {
		this.page = page.getNumber() + 1;
		this.size = page.getSize();
		this.totalCount = (int)page.getTotalElements();
		this.totalPage = page.getTotalPages();		
	}
}
