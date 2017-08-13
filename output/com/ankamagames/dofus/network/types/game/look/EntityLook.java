package com.ankamagames.dofus.network.types.game.look;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class EntityLook extends Object implements INetworkType {

    private int protocolId = 55;
    private int bonesId = 0;
    private int[] skins;
    private int[] indexedColors;
    private int[] scales;
    private SubEntity[] subentities;
    private FuncTree _skinstree;
    private FuncTree _indexedColorstree;
    private FuncTree _scalestree;
    private FuncTree _subentitiestree;


    public void serialize(ICustomDataOutput param1) {
         if(this.bonesId < 0)
         {
            throw new Exception("Forbidden value (" + this.bonesId + ") on element bonesId.");
         }
         param1.writeVarShort(this.bonesId);
         param1.writeShort(this.skins.length);
         int _loc2_ = 0;
         while(_loc2_ < this.skins.length)
         {
            if(this.skins[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.skins[_loc2_] + ") on element 2 (starting at 1) of skins.");
            }
            param1.writeVarShort(this.skins[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.indexedColors.length);
         int _loc3_ = 0;
         while(_loc3_ < this.indexedColors.length)
         {
            param1.writeInt(this.indexedColors[_loc3_]);
            _loc3_++;
         }
         param1.writeShort(this.scales.length);
         int _loc4_ = 0;
         while(_loc4_ < this.scales.length)
         {
            param1.writeVarShort(this.scales[_loc4_]);
            _loc4_++;
         }
         param1.writeShort(this.subentities.length);
         int _loc5_ = 0;
         while(_loc5_ < this.subentities.length)
         {
            (this.subentities[_loc5_] as SubEntity).serializeAs_SubEntity(param1);
            _loc5_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc10_ = 0;
         Object _loc11_ = 0;
         Object _loc12_ = 0;
         SubEntity _loc13_ = null;
         this.bonesId = param1.readVarUhShort();
         if(this.bonesId < 0)
         {
            throw new Exception("Forbidden value (" + this.bonesId + ") on element of EntityLook.bonesId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc10_ = param1.readVarUhShort();
            if(_loc10_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc10_ + ") on elements of skins.");
            }
            this.skins.push(_loc10_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc11_ = param1.readInt();
            this.indexedColors.push(_loc11_);
            _loc5_++;
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc12_ = param1.readVarShort();
            this.scales.push(_loc12_);
            _loc7_++;
         }
         int _loc8_ = param1.readUnsignedShort();
         int _loc9_ = 0;
         while(_loc9_ < _loc8_)
         {
            _loc13_ = new SubEntity();
            _loc13_.deserialize(param1);
            this.subentities.push(_loc13_);
            _loc9_++;
         }
    }

}