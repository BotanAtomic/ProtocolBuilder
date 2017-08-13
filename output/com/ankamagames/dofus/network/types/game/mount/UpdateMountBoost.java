package package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class UpdateMountBoost extends Object implements INetworkType {

    private int protocolId = 356;
    private int type = 0;


    public int getTypeId() {
         return 356;
    }

    public UpdateMountBoost initUpdateMountBoost(int param1) {
         this.type = param1;
         return this;
    }

    public void reset() {
         this.type = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_UpdateMountBoost(param1);
    }

    public void serializeAs_UpdateMountBoost(ICustomDataOutput param1) {
         param1.writeByte(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_UpdateMountBoost(param1);
    }

    public void deserializeAs_UpdateMountBoost(ICustomDataInput param1) {
         this._typeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_UpdateMountBoost(param1);
    }

    public void deserializeAsyncAs_UpdateMountBoost(FuncTree param1) {
         param1.addChild(this._typeFunc);
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
            throw new Exception("Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }

}