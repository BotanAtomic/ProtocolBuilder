package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.ActorOrientation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapChangeOrientationsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6155;
    private boolean _isInitialized = false;
    private Vector<ActorOrientation> orientations;
    private FuncTree _orientationstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6155;
    }

    public GameMapChangeOrientationsMessage initGameMapChangeOrientationsMessage(Vector<ActorOrientation> param1) {
         this.orientations = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.orientations = new Vector.<ActorOrientation>();
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
         this.serializeAs_GameMapChangeOrientationsMessage(param1);
    }

    public void serializeAs_GameMapChangeOrientationsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.orientations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.orientations.length)
         {
            (this.orientations[_loc2_] as ActorOrientation).serializeAs_ActorOrientation(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameMapChangeOrientationsMessage(param1);
    }

    public void deserializeAs_GameMapChangeOrientationsMessage(ICustomDataInput param1) {
         ActorOrientation _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ActorOrientation();
            _loc4_.deserialize(param1);
            this.orientations.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameMapChangeOrientationsMessage(param1);
    }

    public void deserializeAsyncAs_GameMapChangeOrientationsMessage(FuncTree param1) {
         this._orientationstree = param1.addChild(this._orientationstreeFunc);
    }

    private void _orientationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._orientationstree.addChild(this._orientationsFunc);
            _loc3_++;
         }
    }

    private void _orientationsFunc(ICustomDataInput param1) {
         ActorOrientation _loc2_ = new ActorOrientation();
         _loc2_.deserialize(param1);
         this.orientations.push(_loc2_);
    }

}