package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class BasicDateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 177;
    private boolean _isInitialized = false;
    private int day = 0;
    private int month = 0;
    private int year = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.day < 0)
         {
            throw new Exception("Forbidden value (" + this.day + ") on element day.");
         }
         param1.writeByte(this.day);
         if(this.month < 0)
         {
            throw new Exception("Forbidden value (" + this.month + ") on element month.");
         }
         param1.writeByte(this.month);
         if(this.year < 0)
         {
            throw new Exception("Forbidden value (" + this.year + ") on element year.");
         }
         param1.writeShort(this.year);
    }

    public void deserialize(ICustomDataInput param1) {
         this.day = param1.readByte();
         if(this.day < 0)
         {
            throw new Exception("Forbidden value (" + this.day + ") on element of BasicDateMessage.day.");
         }
         this.month = param1.readByte();
         if(this.month < 0)
         {
            throw new Exception("Forbidden value (" + this.month + ") on element of BasicDateMessage.month.");
         }
         this.year = param1.readShort();
         if(this.year < 0)
         {
            throw new Exception("Forbidden value (" + this.year + ") on element of BasicDateMessage.year.");
         }
    }

}