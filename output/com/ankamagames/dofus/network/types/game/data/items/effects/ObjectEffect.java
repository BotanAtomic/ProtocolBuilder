package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectEffect extends Object implements INetworkType {

    private int protocolId = 76;
    private int actionId = 0;


    public int getTypeId() {
         return 76;
    }

    public ObjectEffect initObjectEffect(int param1) {
         this.actionId = param1;
         return this;
    }

    public void reset() {
         this.actionId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffect(param1);
    }

    public void serializeAs_ObjectEffect(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffect(param1);
    }

    public void deserializeAs_ObjectEffect(ICustomDataInput param1) {
         this._actionIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffect(param1);
    }

    public void deserializeAsyncAs_ObjectEffect(FuncTree param1) {
         param1.addChild(this._actionIdFunc);
    }

    private void _actionIdFunc(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
    }

}