package com.fdproject.paging;

import com.fdproject.domain.DrugDTO;
import lombok.Data;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@Data
public class Criteria {
    /**
     * 현재 페이지 번호
     */
    private int currentPageNo;

    /**
     * 페이지당 출력할 데이터 개수
     */
    private int recordsPerPage;

    /**
     * 화면 하단에 출력할 페이지 사이즈
     */
    private int pageSize;

    /**
     * 검색 키워드
     */
    private String searchKeyword;

    /**
     * 검색 유형
     */
    private String searchType;

    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 9;
        this.pageSize = 10;
    }

//    public int getStartPage() {
//        return (currentPageNo - 1) * recordsPerPage;
//    }

    public String makeQueryString(int pageNo) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", recordsPerPage)
                .queryParam("pageSize", pageSize)
                .queryParam("searchType", searchType)
                .queryParam("searchKeyword", searchKeyword)
                .build()
                .encode();

        return uriComponents.toUriString();
    }

}