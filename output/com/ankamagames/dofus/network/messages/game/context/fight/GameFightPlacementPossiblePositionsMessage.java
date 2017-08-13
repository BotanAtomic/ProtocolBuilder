package com.ankamagames.dofus.network.messages.game.context.fight;

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
import java.lang.Exception;
import java.lang.Exception;

public class GameFightPlacementPossiblePositionsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 703;
    private boolean _isInitialized = false;
    private Vector<uint> positionsForChallengers;
    private Vector<uint> positionsForDefenders;
    private int teamNumber = 2;
    private FuncTree _positionsForChallengerstree;
    private FuncTree _positionsForDefenderstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 703;
    }

    public GameFightPlacementPossiblePositionsMessage initGameFightPlacementPossiblePositionsMessage(Vector<uint> param1,Vector<uint>  param2,int  param3) {
         this.positionsForChallengers = param1;
         this.positionsForDefenders = param2;
         this.teamNumber = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.positionsForChallengers = new Vector.<uint>();
         this.positionsForDefenders = new Vector.<uint>();
         this.teamNumber = 2;
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
         this.serializeAs_GameFightPlacementPossiblePositionsMessage(param1);
    }

    public void serializeAs_GameFightPlacementPossiblePositionsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.positionsForChallengers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.positionsForChallengers.length)
         {
            if(this.positionsForChallengers[_loc2_] < 0 || this.positionsForChallengers[_loc2_] > 559)
            {
               throw new Exception("Forbidden value (" + this.positionsForChallengers[_loc2_] + ") on element 1 (starting at 1) of positionsForChallengers.");
            }
            param1.writeVarShort(this.positionsForChallengers[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.positionsForDefenders.length);
         int _loc3_ = 0;
         while(_loc3_ < this.positionsForDefenders.length)
         {
            if(this.positionsForDefenders[_loc3_] < 0 || this.positionsForDefenders[_loc3_] > 559)
            {
               throw new Exception("Forbidden value (" + this.positionsForDefenders[_loc3_] + ") on element 2 (starting at 1) of positionsForDefenders.");
            }
            param1.writeVarShort(this.positionsForDefenders[_loc3_]);
            _loc3_++;
         }
         param1.writeByte(this.teamNumber);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightPlacementPossiblePositionsMessage(param1);
    }

    public void deserializeAs_GameFightPlacementPossiblePositionsMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0 || _loc6_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of positionsForChallengers.");
            }
            this.positionsForChallengers.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhShort();
            if(_loc7_ < 0 || _loc7_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of positionsForDefenders.");
            }
            this.positionsForDefenders.push(_loc7_);
            _loc5_++;
         }
         this._teamNumberFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightPlacementPossiblePositionsMessage(param1);
    }

    public void deserializeAsyncAs_GameFightPlacementPossiblePositionsMessage(FuncTree param1) {
         this._positionsForChallengerstree = param1.addChild(this._positionsForChallengerstreeFunc);
         this._positionsForDefenderstree = param1.addChild(this._positionsForDefenderstreeFunc);
         param1.addChild(this._teamNumberFunc);
    }

    private void _positionsForChallengerstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._positionsForChallengerstree.addChild(this._positionsForChallengersFunc);
            _loc3_++;
         }
    }

    private void _positionsForChallengersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of positionsForChallengers.");
         }
         this.positionsForChallengers.push(_loc2_);
    }

    private void _positionsForDefenderstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._positionsForDefenderstree.addChild(this._positionsForDefendersFunc);
            _loc3_++;
         }
    }

    private void _positionsForDefendersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of positionsForDefenders.");
         }
         this.positionsForDefenders.push(_loc2_);
    }

    private void _teamNumberFunc(ICustomDataInput param1) {
         this.teamNumber = param1.readByte();
         if(this.teamNumber < 0)
         {
            throw new Exception("Forbidden value (" + this.teamNumber + ") on element of GameFightPlacementPossiblePositionsMessage.teamNumber.");
         }
    }

}