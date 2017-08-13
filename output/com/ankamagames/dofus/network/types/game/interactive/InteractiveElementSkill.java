package package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class InteractiveElementSkill extends Object implements INetworkType {

    private int protocolId = 219;
    private int skillId = 0;
    private int skillInstanceUid = 0;


    public int getTypeId() {
         return 219;
    }

    public InteractiveElementSkill initInteractiveElementSkill(int param1,int  param2) {
         this.skillId = param1;
         this.skillInstanceUid = param2;
         return this;
    }

    public void reset() {
         this.skillId = 0;
         this.skillInstanceUid = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_InteractiveElementSkill(param1);
    }

    public void serializeAs_InteractiveElementSkill(ICustomDataOutput param1) {
         if(this.skillId < 0)
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveElementSkill(param1);
    }

    public void deserializeAs_InteractiveElementSkill(ICustomDataInput param1) {
         this._skillIdFunc(param1);
         this._skillInstanceUidFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveElementSkill(param1);
    }

    public void deserializeAsyncAs_InteractiveElementSkill(FuncTree param1) {
         param1.addChild(this._skillIdFunc);
         param1.addChild(this._skillInstanceUidFunc);
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
            throw new Exception("Forbidden value (" + this.skillId + ") on element of InteractiveElementSkill.skillId.");
    }

    private void _skillInstanceUidFunc(ICustomDataInput param1) {
         this.skillInstanceUid = param1.readInt();
         if(this.skillInstanceUid < 0)
            throw new Exception("Forbidden value (" + this.skillInstanceUid + ") on element of InteractiveElementSkill.skillInstanceUid.");
    }

}