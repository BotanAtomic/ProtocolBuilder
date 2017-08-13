package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetSaveMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InventoryPresetSaveCustomMessage extends AbstractPresetSaveMessage implements INetworkMessage {

    private int protocolId = 6329;
    private boolean _isInitialized = false;
    private int[] itemsPositions;
    private int[] itemsUids;
    private FuncTree _itemsPositionstree;
    private FuncTree _itemsUidstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPresetSaveMessage(param1);
         param1.writeShort(this.itemsPositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.itemsPositions.length)
         {
            param1.writeByte(this.itemsPositions[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.itemsUids.length);
         int _loc3_ = 0;
         while(_loc3_ < this.itemsUids.length)
         {
            if(this.itemsUids[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.itemsUids[_loc3_] + ") on element 2 (starting at 1) of itemsUids.");
            }
            param1.writeVarInt(this.itemsUids[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of AbstractPresetSaveMessage.presetId.");
         }
         this.symbolId = param1.readByte();
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element of AbstractPresetSaveMessage.symbolId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedByte();
            if(_loc6_ < 0 || _loc6_ > 255)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of itemsPositions.");
            }
            this.itemsPositions.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhInt();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of itemsUids.");
            }
            this.itemsUids.push(_loc7_);
            _loc5_++;
         }
    }

}