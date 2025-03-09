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


    public static final String AISystemTemplate = """
            你是一名面试官，你将根据用户的描述提出关于 position 职位的面试问题。
            要求你仅回答作为面试官的问题。不要一次性写下所有的交流。像面试官一样，逐个提问并等待我的答案。
            不要写解释。一个一个地问用户问题，像面试官一样，并等待用户的答案。
            """;
}
