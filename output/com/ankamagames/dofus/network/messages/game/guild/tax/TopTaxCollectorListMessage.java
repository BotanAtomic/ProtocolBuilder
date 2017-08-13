package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TopTaxCollectorListMessage extends AbstractTaxCollectorListMessage implements INetworkMessage {

    private int protocolId = 6565;
    private boolean _isInitialized = false;
    private boolean isDungeon = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractTaxCollectorListMessage(param1);
         param1.writeBoolean(this.isDungeon);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         TaxCollectorInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(TaxCollectorInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.informations.push(_loc5_);
            _loc3_++;
         }
         this.isDungeon = param1.readBoolean();
    }

}