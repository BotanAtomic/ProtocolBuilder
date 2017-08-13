package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class UpdateMountIntBoost extends UpdateMountBoost implements INetworkType {

    private int protocolId = 357;
    private int value = 0;


    public int getTypeId() {
         return 357;
    }

    public UpdateMountIntBoost initUpdateMountIntBoost(int param1,int  param2) {
         super.initUpdateMountBoost(param1);
         this.value = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.value = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_UpdateMountIntBoost(param1);
    }

    public void serializeAs_UpdateMountIntBoost(ICustomDataOutput param1) {
         super.serializeAs_UpdateMountBoost(param1);
         param1.writeInt(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_UpdateMountIntBoost(param1);
    }

    public void deserializeAs_UpdateMountIntBoost(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_UpdateMountIntBoost(param1);
    }

    public void deserializeAsyncAs_UpdateMountIntBoost(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readInt();
    }

}