package com.ankamagames.dofus.network.messages.game.context.display;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DisplayNumericalValuePaddockMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6563;
    private boolean _isInitialized = false;
    private int rideId = 0;
    private int value = 0;
    private int type = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.rideId);
         param1.writeInt(this.value);
         param1.writeByte(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.rideId = param1.readInt();
         this.value = param1.readInt();
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of DisplayNumericalValuePaddockMessage.type.");
         }
    }

}