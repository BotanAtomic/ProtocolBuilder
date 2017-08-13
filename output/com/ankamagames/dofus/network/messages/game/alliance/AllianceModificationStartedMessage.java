package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class AllianceModificationStartedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6444;
    private boolean _isInitialized = false;
    private boolean canChangeName = false;
    private boolean canChangeTag = false;
    private boolean canChangeEmblem = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6444;
    }

    public AllianceModificationStartedMessage initAllianceModificationStartedMessage(boolean param1,boolean  param2,boolean  param3) {
         this.canChangeName = param1;
         this.canChangeTag = param2;
         this.canChangeEmblem = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.canChangeName = false;
         this.canChangeTag = false;
         this.canChangeEmblem = false;
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
         this.serializeAs_AllianceModificationStartedMessage(param1);
    }

    public void serializeAs_AllianceModificationStartedMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.canChangeName);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.canChangeTag);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.canChangeEmblem);
         param1.writeByte(_loc2_);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceModificationStartedMessage(param1);
    }

    public void deserializeAs_AllianceModificationStartedMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceModificationStartedMessage(param1);
    }

    public void deserializeAsyncAs_AllianceModificationStartedMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.canChangeName = BooleanByteWrapper.getFlag(_loc2_,0);
         this.canChangeTag = BooleanByteWrapper.getFlag(_loc2_,1);
         this.canChangeEmblem = BooleanByteWrapper.getFlag(_loc2_,2);
    }

}