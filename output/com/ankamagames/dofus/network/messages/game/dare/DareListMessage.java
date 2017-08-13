package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6661;
    private boolean _isInitialized = false;
    private DareInformations[] dares;
    private FuncTree _darestree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.dares.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dares.length)
         {
            (this.dares[_loc2_] as DareInformations).serializeAs_DareInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         DareInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DareInformations();
            _loc4_.deserialize(param1);
            this.dares.push(_loc4_);
            _loc3_++;
         }
    }

}