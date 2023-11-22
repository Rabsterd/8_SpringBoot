package edu.kh.project.board.model.service;

import java.util.List;

import edu.kh.project.board.model.dto.Comment;

public interface CommentService {

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return cList
	 */
	List<Comment> select(int boardNo);

	/** 댓글 삽입 
	 * @param comment
	 * @return result
	 */
	int insert(Comment comment);

	int delete(int commentNo);

	int update(Comment comment);

}
