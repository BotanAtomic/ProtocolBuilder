package com.ankamagames.dofus.network.types.game.inventory.preset;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class Preset extends Object implements INetworkType {

    private int protocolId = 355;
    private int presetId = 0;
    private int symbolId = 0;
    private boolean mount = false;
    private PresetItem[] objects;
    private FuncTree _objectstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element symbolId.");
         }
         param1.writeByte(this.symbolId);
         param1.writeBoolean(this.mount);
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
         {
            (this.objects[_loc2_] as PresetItem).serializeAs_PresetItem(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PresetItem _loc4_ = null;
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of Preset.presetId.");
         }
         this.symbolId = param1.readByte();
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element of Preset.symbolId.");
         }
         this.mount = param1.readBoolean();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PresetItem();
            _loc4_.deserialize(param1);
            this.objects.push(_loc4_);
            _loc3_++;
         }
    }

}