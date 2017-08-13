package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class EnterHavenBagRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6636;
    private boolean _isInitialized = false;
    private Number havenBagOwner = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6636;
    }

    public EnterHavenBagRequestMessage initEnterHavenBagRequestMessage(Number param1) {
         this.havenBagOwner = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.havenBagOwner = 0;
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
         this.serializeAs_EnterHavenBagRequestMessage(param1);
    }

    public void serializeAs_EnterHavenBagRequestMessage(ICustomDataOutput param1) {
         if(this.havenBagOwner < 0 || this.havenBagOwner > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.havenBagOwner + ") on element havenBagOwner.");
         }
         param1.writeVarLong(this.havenBagOwner);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EnterHavenBagRequestMessage(param1);
    }

    public void deserializeAs_EnterHavenBagRequestMessage(ICustomDataInput param1) {
         this._havenBagOwnerFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EnterHavenBagRequestMessage(param1);
    }

    public void deserializeAsyncAs_EnterHavenBagRequestMessage(FuncTree param1) {
         param1.addChild(this._havenBagOwnerFunc);
    }

    private void _havenBagOwnerFunc(ICustomDataInput param1) {
         this.havenBagOwner = param1.readVarUhLong();
         if(this.havenBagOwner < 0 || this.havenBagOwner > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.havenBagOwner + ") on element of EnterHavenBagRequestMessage.havenBagOwner.");
         }
    }

}