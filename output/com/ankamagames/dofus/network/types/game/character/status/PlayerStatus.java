package com.ankamagames.dofus.network.types.game.character.status;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PlayerStatus extends Object implements INetworkType {

    private int protocolId = 415;
    private int statusId = 1;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.statusId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.statusId = param1.readByte();
         if(this.statusId < 0)
         {
            throw new Exception("Forbidden value (" + this.statusId + ") on element of PlayerStatus.statusId.");
         }
    }

}