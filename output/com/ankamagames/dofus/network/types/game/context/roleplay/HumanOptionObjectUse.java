package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HumanOptionObjectUse extends HumanOption implements INetworkType {

    private int protocolId = 449;
    private int delayTypeId = 0;
    private Number delayEndTime = 0;
    private int objectGID = 0;


    public int getTypeId() {
         return 449;
    }

    public HumanOptionObjectUse initHumanOptionObjectUse(int param1,Number  param2,int  param3) {
         this.delayTypeId = param1;
         this.delayEndTime = param2;
         this.objectGID = param3;
         return this;
    }

    public void reset() {
         this.delayTypeId = 0;
         this.delayEndTime = 0;
         this.objectGID = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionObjectUse(param1);
    }

    public void serializeAs_HumanOptionObjectUse(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         param1.writeByte(this.delayTypeId);
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionObjectUse(param1);
    }

    public void deserializeAs_HumanOptionObjectUse(ICustomDataInput param1) {
         super.deserialize(param1);
         this._delayTypeIdFunc(param1);
         this._delayEndTimeFunc(param1);
         this._objectGIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionObjectUse(param1);
    }

    public void deserializeAsyncAs_HumanOptionObjectUse(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._delayTypeIdFunc);
         param1.addChild(this._delayEndTimeFunc);
         param1.addChild(this._objectGIDFunc);
    }

    private void _delayTypeIdFunc(ICustomDataInput param1) {
         this.delayTypeId = param1.readByte();
         if(this.delayTypeId < 0)
            throw new Exception("Forbidden value (" + this.delayTypeId + ") on element of HumanOptionObjectUse.delayTypeId.");
    }

    private void _delayEndTimeFunc(ICustomDataInput param1) {
         this.delayEndTime = param1.readDouble();
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element of HumanOptionObjectUse.delayEndTime.");
    }

    private void _objectGIDFunc(ICustomDataInput param1) {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of HumanOptionObjectUse.objectGID.");
    }

}