package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartOkMountWithOutPaddockMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5991;
    private boolean _isInitialized = false;
    private MountClientData[] stabledMountsDescription;
    private FuncTree _stabledMountsDescriptiontree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.stabledMountsDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.stabledMountsDescription.length)
         {
            (this.stabledMountsDescription[_loc2_] as MountClientData).serializeAs_MountClientData(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         MountClientData _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MountClientData();
            _loc4_.deserialize(param1);
            this.stabledMountsDescription.push(_loc4_);
            _loc3_++;
         }
    }

}