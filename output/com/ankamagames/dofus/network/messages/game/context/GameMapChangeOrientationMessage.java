package package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.ActorOrientation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapChangeOrientationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 946;
    private boolean _isInitialized = false;
    private ActorOrientation orientation = ;
    private FuncTree _orientationtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 946;
    }

    public GameMapChangeOrientationMessage initGameMapChangeOrientationMessage(ActorOrientation param1) {
         this.orientation = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.orientation = new ActorOrientation();
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
         this.serializeAs_GameMapChangeOrientationMessage(param1);
    }

    public void serializeAs_GameMapChangeOrientationMessage(ICustomDataOutput param1) {
         this.orientation.serializeAs_ActorOrientation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameMapChangeOrientationMessage(param1);
    }

    public void deserializeAs_GameMapChangeOrientationMessage(ICustomDataInput param1) {
         this.orientation = new ActorOrientation();
         this.orientation.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameMapChangeOrientationMessage(param1);
    }

    public void deserializeAsyncAs_GameMapChangeOrientationMessage(FuncTree param1) {
         this._orientationtree = param1.addChild(this._orientationtreeFunc);
    }

    private void _orientationtreeFunc(ICustomDataInput param1) {
         this.orientation = new ActorOrientation();
         this.orientation.deserializeAsync(this._orientationtree);
    }

}