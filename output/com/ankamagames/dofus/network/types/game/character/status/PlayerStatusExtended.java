package package com.ankamagames.dofus.network.types.game.character.status;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PlayerStatusExtended extends PlayerStatus implements INetworkType {

    private int protocolId = 414;
    private String message = "";


    public int getTypeId() {
         return 414;
    }

    public PlayerStatusExtended initPlayerStatusExtended(int param1,String  param2) {
         super.initPlayerStatus(param1);
         this.message = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.message = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PlayerStatusExtended(param1);
    }

    public void serializeAs_PlayerStatusExtended(ICustomDataOutput param1) {
         super.serializeAs_PlayerStatus(param1);
         param1.writeUTF(this.message);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PlayerStatusExtended(param1);
    }

    public void deserializeAs_PlayerStatusExtended(ICustomDataInput param1) {
         super.deserialize(param1);
         this._messageFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PlayerStatusExtended(param1);
    }

    public void deserializeAsyncAs_PlayerStatusExtended(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._messageFunc);
    }

    private void _messageFunc(ICustomDataInput param1) {
         this.message = param1.readUTF();
    }

}