package org.chenjh.aiqasystem.ai.prompt;

/**
 * @author hjong
 * @date 2025−02−25
 */
public class Template {

    public static final String questionTemplate = """
            
            我正在解答一些的题目，需要你的帮助。请按照以下要求回答我提供的每个问题：
            
            1. 如果我的回答和题目不相关，请直接回复：请回答和问题相关的内容
            2. 先简明扼要地直接给出答案
            3. 然后提供详细的解析和思路分析
            4. 如果是计算题，请展示完整的计算步骤
            5. 如果有多种解法，请说明各种方法的优缺点
            6. 指出可能的易错点和需要注意的关键概念
            7. 如果题目或我的回答中有模糊或不明确的地方，请指出并给出在不同理解下的答案
            
            以下是题目：{question}
            我的回答是：{message}
            """;

    public static final String interviewTemplate = """
            
            """;
}
