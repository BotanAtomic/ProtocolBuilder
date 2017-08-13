package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class IdolsPresetUseResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6614;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private int code = 3;
    private int[] missingIdols;
    private FuncTree _missingIdolstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         param1.writeByte(this.code);
         param1.writeShort(this.missingIdols.length);
         int _loc2_ = 0;
         while(_loc2_ < this.missingIdols.length)
         {
            if(this.missingIdols[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.missingIdols[_loc2_] + ") on element 3 (starting at 1) of missingIdols.");
            }
            param1.writeVarShort(this.missingIdols[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of IdolsPresetUseResultMessage.presetId.");
         }
         this.code = param1.readByte();
         if(this.code < 0)
         {
            throw new Exception("Forbidden value (" + this.code + ") on element of IdolsPresetUseResultMessage.code.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of missingIdols.");
            }
            this.missingIdols.push(_loc4_);
            _loc3_++;
         }
    }

}