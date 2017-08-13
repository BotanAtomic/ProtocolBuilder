package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorMovement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorMovementsOfflineMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6611;
    private boolean _isInitialized = false;
    private TaxCollectorMovement[] movements;
    private FuncTree _movementstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.movements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.movements.length)
         {
            (this.movements[_loc2_] as TaxCollectorMovement).serializeAs_TaxCollectorMovement(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         TaxCollectorMovement _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new TaxCollectorMovement();
            _loc4_.deserialize(param1);
            this.movements.push(_loc4_);
            _loc3_++;
         }
    }

}