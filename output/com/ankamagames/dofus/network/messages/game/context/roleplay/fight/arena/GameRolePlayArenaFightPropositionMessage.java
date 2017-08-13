package package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

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
import java.lang.Exception;

public class GameRolePlayArenaFightPropositionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6276;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private Vector.<Number> alliesId = ;
    private int duration = 0;
    private FuncTree _alliesIdtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6276;
    }

    public GameRolePlayArenaFightPropositionMessage initGameRolePlayArenaFightPropositionMessage(int param1,Vector.<Number>  param2,int  param3) {
         this.fightId = param1;
         this.alliesId = param2;
         this.duration = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.alliesId = new Vector.<Number>();
         this.duration = 0;
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
         this.serializeAs_GameRolePlayArenaFightPropositionMessage(param1);
    }

    public void serializeAs_GameRolePlayArenaFightPropositionMessage(ICustomDataOutput param1) {
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaFightPropositionMessage(param1);
    }

    public void deserializeAs_GameRolePlayArenaFightPropositionMessage(ICustomDataInput param1) {
         * _loc4_ = NaN;
         this._fightIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readDouble();
            if(_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of alliesId.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayArenaFightPropositionMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayArenaFightPropositionMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         this._alliesIdtree = param1.addChild(this._alliesIdtreeFunc);
         param1.addChild(this._durationFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GameRolePlayArenaFightPropositionMessage.fightId.");
    }

    private void _alliesIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._alliesIdtree.addChild(this._alliesIdFunc);
            _loc3_++;
    }

    private void _alliesIdFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readDouble();
         if(_loc2_ < -9.007199254740992E15 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of alliesId.");
    }

    private void _durationFunc(ICustomDataInput param1) {
         this.duration = param1.readVarUhShort();
         if(this.duration < 0)
            throw new Exception("Forbidden value (" + this.duration + ") on element of GameRolePlayArenaFightPropositionMessage.duration.");
    }

}