package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class EmoteListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5689;
    private boolean _isInitialized = false;
    private int[] emoteIds;
    private FuncTree _emoteIdstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.emoteIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.emoteIds.length)
         {
            if(this.emoteIds[_loc2_] < 0 || this.emoteIds[_loc2_] > 255)
            {
               throw new Exception("Forbidden value (" + this.emoteIds[_loc2_] + ") on element 1 (starting at 1) of emoteIds.");
            }
            param1.writeByte(this.emoteIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedByte();
            if(_loc4_ < 0 || _loc4_ > 255)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of emoteIds.");
            }
            this.emoteIds.push(_loc4_);
            _loc3_++;
         }
    }

}