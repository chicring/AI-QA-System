package org.chenjh.aiqasystem.domain.convert;

import com.nrapendra.jooq.tables.records.TagRecord;
import org.chenjh.aiqasystem.domain.dto.TagDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TagConvert {

    public static TagDTO convert(TagRecord tagRecord) {
        return TagDTO.builder()
                .id(tagRecord.getTagId())
                .name(tagRecord.getTagName())
                .build();
    }

    public static List<TagDTO> convert(List<TagRecord> tagRecords) {
        return tagRecords.stream().map(TagConvert::convert).collect(Collectors.toList());
    }
}
