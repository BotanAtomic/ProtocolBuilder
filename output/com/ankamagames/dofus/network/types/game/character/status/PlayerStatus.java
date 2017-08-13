package com.ankamagames.dofus.network.types.game.character.status;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PlayerStatus extends Object implements INetworkType {

    private int protocolId = 415;
    private int statusId = 1;


    public int getTypeId() {
         return 415;
    }

    public PlayerStatus initPlayerStatus(int param1) {
         this.statusId = param1;
         return this;
    }

    public void reset() {
         this.statusId = 1;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PlayerStatus(param1);
    }

    public void serializeAs_PlayerStatus(ICustomDataOutput param1) {
         param1.writeByte(this.statusId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PlayerStatus(param1);
    }

    public void deserializeAs_PlayerStatus(ICustomDataInput param1) {
         this._statusIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PlayerStatus(param1);
    }

    public void deserializeAsyncAs_PlayerStatus(FuncTree param1) {
         param1.addChild(this._statusIdFunc);
    }

    private void _statusIdFunc(ICustomDataInput param1) {
         this.statusId = param1.readByte();
         if(this.statusId < 0)
         {
            throw new Exception("Forbidden value (" + this.statusId + ") on element of PlayerStatus.statusId.");
         }
    }

}