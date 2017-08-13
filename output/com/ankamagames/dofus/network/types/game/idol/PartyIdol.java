package com.ankamagames.dofus.network.types.game.idol;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyIdol extends Idol implements INetworkType {

    private int protocolId = 490;
    private Number[] ownersIds;
    private FuncTree _ownersIdstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_Idol(param1);
         param1.writeShort(this.ownersIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ownersIds.length)
         {
            if(this.ownersIds[_loc2_] < 0 || this.ownersIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.ownersIds[_loc2_] + ") on element 1 (starting at 1) of ownersIds.");
            }
            param1.writeVarLong(this.ownersIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = NaN;
         int _loc4_ = 0;
         Idol _loc5_ = null;
         this.idolSource = param1.readByte();
         if(this.idolSource < 0)
         {
            throw new Exception("Forbidden value (" + this.idolSource + ") on element of IdolFightPreparationUpdateMessage.idolSource.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(Idol,_loc4_);
            _loc5_.deserialize(param1);
            this.idols.push(_loc5_);
            _loc3_++;
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhLong();
            if(_loc4_ < 0 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of ownersIds.");
            }
            this.ownersIds.push(_loc4_);
            _loc3_++;
         }
    }

}