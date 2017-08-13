package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class KickHavenBagRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6652;
    private boolean _isInitialized = false;
    private Number guestId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6652;
    }

    public KickHavenBagRequestMessage initKickHavenBagRequestMessage(Number param1) {
         this.guestId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guestId = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_KickHavenBagRequestMessage(param1);
    }

    public void serializeAs_KickHavenBagRequestMessage(ICustomDataOutput param1) {
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.guestId + ") on element guestId.");
         }
         param1.writeVarLong(this.guestId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_KickHavenBagRequestMessage(param1);
    }

    public void deserializeAs_KickHavenBagRequestMessage(ICustomDataInput param1) {
         this._guestIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_KickHavenBagRequestMessage(param1);
    }

    public void deserializeAsyncAs_KickHavenBagRequestMessage(FuncTree param1) {
         param1.addChild(this._guestIdFunc);
    }

    private void _guestIdFunc(ICustomDataInput param1) {
         this.guestId = param1.readVarUhLong();
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.guestId + ") on element of KickHavenBagRequestMessage.guestId.");
         }
    }

}