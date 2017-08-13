package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightResultPlayerListEntry extends FightResultFighterListEntry implements INetworkType {

    private int protocolId = 24;
    private int level = 0;
    private FightResultAdditionalData[] additional;
    private FuncTree _additionaltree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_FightResultListEntry(param1);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         param1.writeBoolean(this.alive);
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         param1.writeShort(this.additional.length);
         int _loc2_ = 0;
         while(_loc2_ < this.additional.length)
         {
            param1.writeShort((this.additional[_loc2_] as FightResultAdditionalData).getTypeId());
            (this.additional[_loc2_] as FightResultAdditionalData).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         FightResultAdditionalData _loc5_ = null;
         this.deserializeAs_FightResultListEntry(param1);
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightResultFighterListEntry.id.");
         }
         this.alive = param1.readBoolean();
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightResultPlayerListEntry.level.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(FightResultAdditionalData,_loc4_);
            _loc5_.deserialize(param1);
            this.additional.push(_loc5_);
            _loc3_++;
         }
    }

}