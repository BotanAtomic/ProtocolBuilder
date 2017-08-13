package com.ankamagames.dofus.network.messages.game.finishmoves;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.finishmoves.FinishMoveInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FinishMoveListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6704;
    private boolean _isInitialized = false;
    private Vector<FinishMoveInformations> finishMoves;
    private FuncTree _finishMovestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6704;
    }

    public FinishMoveListMessage initFinishMoveListMessage(Vector<FinishMoveInformations> param1) {
         this.finishMoves = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.finishMoves = new Vector.<FinishMoveInformations>();
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
         this.serializeAs_FinishMoveListMessage(param1);
    }

    public void serializeAs_FinishMoveListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.finishMoves.length);
         int _loc2_ = 0;
         while(_loc2_ < this.finishMoves.length)
         {
            (this.finishMoves[_loc2_] as FinishMoveInformations).serializeAs_FinishMoveInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FinishMoveListMessage(param1);
    }

    public void deserializeAs_FinishMoveListMessage(ICustomDataInput param1) {
         FinishMoveInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new FinishMoveInformations();
            _loc4_.deserialize(param1);
            this.finishMoves.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FinishMoveListMessage(param1);
    }

    public void deserializeAsyncAs_FinishMoveListMessage(FuncTree param1) {
         this._finishMovestree = param1.addChild(this._finishMovestreeFunc);
    }

    private void _finishMovestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._finishMovestree.addChild(this._finishMovesFunc);
            _loc3_++;
         }
    }

    private void _finishMovesFunc(ICustomDataInput param1) {
         FinishMoveInformations _loc2_ = new FinishMoveInformations();
         _loc2_.deserialize(param1);
         this.finishMoves.push(_loc2_);
    }

}