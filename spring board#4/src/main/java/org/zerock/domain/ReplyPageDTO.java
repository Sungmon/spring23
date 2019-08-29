package org.zerock.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor //@AllArgsConstructor는 모든 필드를 파라미터로 가지는 생성자를 만든다. 
@Getter
public class ReplyPageDTO {

	private int replyCnt;
	private List<ReplyVO> list;
	
}
