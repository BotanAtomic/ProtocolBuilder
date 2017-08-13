package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class InteractiveUseEndedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6112;
    private boolean _isInitialized = false;
    private int elemId = 0;
    private int skillId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6112;
    }

    public InteractiveUseEndedMessage initInteractiveUseEndedMessage(int param1,int  param2) {
         this.elemId = param1;
         this.skillId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.elemId = 0;
         this.skillId = 0;
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
         this.serializeAs_InteractiveUseEndedMessage(param1);
    }

    public void serializeAs_InteractiveUseEndedMessage(ICustomDataOutput param1) {
         if(this.elemId < 0)
         {
            throw new Exception("Forbidden value (" + this.elemId + ") on element elemId.");
         }
         param1.writeVarInt(this.elemId);
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarShort(this.skillId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveUseEndedMessage(param1);
    }

    public void deserializeAs_InteractiveUseEndedMessage(ICustomDataInput param1) {
         this._elemIdFunc(param1);
         this._skillIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveUseEndedMessage(param1);
    }

    public void deserializeAsyncAs_InteractiveUseEndedMessage(FuncTree param1) {
         param1.addChild(this._elemIdFunc);
         param1.addChild(this._skillIdFunc);
    }

    private void _elemIdFunc(ICustomDataInput param1) {
         this.elemId = param1.readVarUhInt();
         if(this.elemId < 0)
         {
            throw new Exception("Forbidden value (" + this.elemId + ") on element of InteractiveUseEndedMessage.elemId.");
         }
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhShort();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of InteractiveUseEndedMessage.skillId.");
         }
    }

}