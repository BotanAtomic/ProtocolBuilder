package com.ankamagames.dofus.network.messages.secure;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class TrustStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6267;
    private boolean _isInitialized = false;
    private boolean trusted = false;
    private boolean certified = false;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.trusted);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.certified);
         param1.writeByte(_loc2_);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.trusted = BooleanByteWrapper.getFlag(_loc2_,0);
         this.certified = BooleanByteWrapper.getFlag(_loc2_,1);
    }

}