package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TextInformationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 780;
    private boolean _isInitialized = false;
    private int msgType = 0;
    private int msgId = 0;
    private String[] parameters;
    private FuncTree _parameterstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.msgType);
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element msgId.");
         }
         param1.writeVarShort(this.msgId);
         param1.writeShort(this.parameters.length);
         int _loc2_ = 0;
         while(_loc2_ < this.parameters.length)
         {
            param1.writeUTF(this.parameters[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         String _loc4_ = null;
         this.msgType = param1.readByte();
         if(this.msgType < 0)
         {
            throw new Exception("Forbidden value (" + this.msgType + ") on element of TextInformationMessage.msgType.");
         }
         this.msgId = param1.readVarUhShort();
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element of TextInformationMessage.msgId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUTF();
            this.parameters.push(_loc4_);
            _loc3_++;
         }
    }

}