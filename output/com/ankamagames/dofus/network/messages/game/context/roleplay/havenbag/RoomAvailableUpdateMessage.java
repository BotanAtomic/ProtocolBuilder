package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class RoomAvailableUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6630;
    private boolean _isInitialized = false;
    private int nbRoom = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.nbRoom < 0 || this.nbRoom > 255)
         {
            throw new Exception("Forbidden value (" + this.nbRoom + ") on element nbRoom.");
         }
         param1.writeByte(this.nbRoom);
    }

    public void deserialize(ICustomDataInput param1) {
         this.nbRoom = param1.readUnsignedByte();
         if(this.nbRoom < 0 || this.nbRoom > 255)
         {
            throw new Exception("Forbidden value (" + this.nbRoom + ") on element of RoomAvailableUpdateMessage.nbRoom.");
         }
    }

}