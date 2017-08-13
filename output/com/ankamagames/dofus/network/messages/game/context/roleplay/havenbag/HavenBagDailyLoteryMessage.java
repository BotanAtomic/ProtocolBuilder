package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HavenBagDailyLoteryMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6644;
    private boolean _isInitialized = false;
    private int returnType = 0;
    private String tokenId = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.returnType);
         param1.writeUTF(this.tokenId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.returnType = param1.readByte();
         if(this.returnType < 0)
         {
            throw new Exception("Forbidden value (" + this.returnType + ") on element of HavenBagDailyLoteryMessage.returnType.");
         }
         this.tokenId = param1.readUTF();
    }

}