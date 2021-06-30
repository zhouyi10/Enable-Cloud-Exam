package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * question content info
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionStemInfoBO {
	
	/** question stem information with html tags */
	public String richText;
	
	/** No HTML tag title stem information  */
	public String plaintext;

}
