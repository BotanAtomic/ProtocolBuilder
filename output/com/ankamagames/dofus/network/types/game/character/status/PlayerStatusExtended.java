package com.ankamagames.dofus.network.types.game.character.status;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PlayerStatusExtended extends PlayerStatus implements INetworkType {

    private int protocolId = 414;
    private String message = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.message);
         param1.writeUTF(this.message);
         super.serializeAs_PlayerStatus(param1);
         param1.writeUTF(this.message);
    }

    public void deserialize(ICustomDataInput param1) {
         this.message = param1.readUTF();
    }

}