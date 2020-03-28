package com.mt.tlstools.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "thickness_info")
public class ThicknessInfoOld {
    private String taskNum;
    private String trainNum;
    private Map<Integer,Double> result;

}
