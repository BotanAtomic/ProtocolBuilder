package package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.EntityMovementInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextMoveElementMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 253;
    private boolean _isInitialized = false;
    private EntityMovementInformations movement = ;
    private FuncTree _movementtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 253;
    }

    public GameContextMoveElementMessage initGameContextMoveElementMessage(EntityMovementInformations param1) {
         this.movement = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.movement = new EntityMovementInformations();
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
         this.serializeAs_GameContextMoveElementMessage(param1);
    }

    public void serializeAs_GameContextMoveElementMessage(ICustomDataOutput param1) {
         this.movement.serializeAs_EntityMovementInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextMoveElementMessage(param1);
    }

    public void deserializeAs_GameContextMoveElementMessage(ICustomDataInput param1) {
         this.movement = new EntityMovementInformations();
         this.movement.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextMoveElementMessage(param1);
    }

    public void deserializeAsyncAs_GameContextMoveElementMessage(FuncTree param1) {
         this._movementtree = param1.addChild(this._movementtreeFunc);
    }

    private void _movementtreeFunc(ICustomDataInput param1) {
         this.movement = new EntityMovementInformations();
         this.movement.deserializeAsync(this._movementtree);
    }

}