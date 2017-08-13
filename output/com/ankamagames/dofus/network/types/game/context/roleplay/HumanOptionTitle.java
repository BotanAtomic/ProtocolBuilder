package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class HumanOptionTitle extends HumanOption implements INetworkType {

    private int protocolId = 408;
    private int titleId = 0;
    private String titleParam = "";


    public int getTypeId() {
         return 408;
    }

    public HumanOptionTitle initHumanOptionTitle(int param1,String  param2) {
         this.titleId = param1;
         this.titleParam = param2;
         return this;
    }

    public void reset() {
         this.titleId = 0;
         this.titleParam = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionTitle(param1);
    }

    public void serializeAs_HumanOptionTitle(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         if(this.titleId < 0)
            throw new Exception("Forbidden value (" + this.titleId + ") on element titleId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionTitle(param1);
    }

    public void deserializeAs_HumanOptionTitle(ICustomDataInput param1) {
         super.deserialize(param1);
         this._titleIdFunc(param1);
         this._titleParamFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionTitle(param1);
    }

    public void deserializeAsyncAs_HumanOptionTitle(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._titleIdFunc);
         param1.addChild(this._titleParamFunc);
    }

    private void _titleIdFunc(ICustomDataInput param1) {
         this.titleId = param1.readVarUhShort();
         if(this.titleId < 0)
            throw new Exception("Forbidden value (" + this.titleId + ") on element of HumanOptionTitle.titleId.");
    }

    private void _titleParamFunc(ICustomDataInput param1) {
         this.titleParam = param1.readUTF();
    }

}