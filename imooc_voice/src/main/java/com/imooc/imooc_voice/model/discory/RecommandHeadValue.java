package com.imooc.imooc_voice.model.discory;

import com.imooc.imooc_voice.model.BaseModel;
import java.util.ArrayList;

public class RecommandHeadValue extends BaseModel {

    public ArrayList<String> ads;
    public ArrayList<RecommandMiddleValue> middle;
    public ArrayList<RecommandFooterValue> footer;

}
