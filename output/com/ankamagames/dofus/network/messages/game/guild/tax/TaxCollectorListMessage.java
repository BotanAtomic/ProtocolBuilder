package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorFightersInformation;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TaxCollectorListMessage extends Abstract {

    private int protocolId = 5930;
    private boolean _isInitialized = false;
    private int nbcollectorMax = 0;
    private TaxCollectorFightersInformation[] fightersInformations;
    private FuncTree _fightersInformationstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractTaxCollectorListMessage(param1);
         if(this.nbcollectorMax < 0)
         {
            throw new Exception("Forbidden value (" + this.nbcollectorMax + ") on element nbcollectorMax.");
         }
         param1.writeByte(this.nbcollectorMax);
         param1.writeShort(this.fightersInformations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.fightersInformations.length)
         {
            (this.fightersInformations[_loc2_] as TaxCollectorFightersInformation).serializeAs_TaxCollectorFightersInformation(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         TaxCollectorFightersInformation _loc4_ = null;
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of AbstractGameActionMessage.actionId.");
         }
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of AbstractGameActionMessage.sourceId.");
         }
         this.nbcollectorMax = param1.readByte();
         if(this.nbcollectorMax < 0)
         {
            throw new Exception("Forbidden value (" + this.nbcollectorMax + ") on element of TaxCollectorListMessage.nbcollectorMax.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new TaxCollectorFightersInformation();
            _loc4_.deserialize(param1);
            this.fightersInformations.push(_loc4_);
            _loc3_++;
         }
    }

}