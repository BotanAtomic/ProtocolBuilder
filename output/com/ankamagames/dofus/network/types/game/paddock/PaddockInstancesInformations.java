package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockInstancesInformations extends PaddockInformations implements INetworkType {

    private int protocolId = 509;
    private PaddockBuyableInformations[] paddocks;
    private FuncTree _paddockstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.maxOutdoorMount < 0)
         {
            throw new Exception("Forbidden value (" + this.maxOutdoorMount + ") on element maxOutdoorMount.");
         }
         param1.writeVarShort(this.maxOutdoorMount);
         if(this.maxItems < 0)
         {
            throw new Exception("Forbidden value (" + this.maxItems + ") on element maxItems.");
         }
         param1.writeVarShort(this.maxItems);
         param1.writeShort(this.paddocks.length);
         int _loc2_ = 0;
         while(_loc2_ < this.paddocks.length)
         {
            param1.writeShort((this.paddocks[_loc2_] as PaddockBuyableInformations).getTypeId());
            (this.paddocks[_loc2_] as PaddockBuyableInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         PaddockBuyableInformations _loc5_ = null;
         this.maxOutdoorMount = param1.readVarUhShort();
         if(this.maxOutdoorMount < 0)
         {
            throw new Exception("Forbidden value (" + this.maxOutdoorMount + ") on element of PaddockInformations.maxOutdoorMount.");
         }
         this.maxItems = param1.readVarUhShort();
         if(this.maxItems < 0)
         {
            throw new Exception("Forbidden value (" + this.maxItems + ") on element of PaddockInformations.maxItems.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(PaddockBuyableInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.paddocks.push(_loc5_);
            _loc3_++;
         }
    }

}