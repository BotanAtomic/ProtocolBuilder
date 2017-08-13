package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayNpcQuestFlag extends Object implements INetworkType {

    private int protocolId = 384;
    private Vector<uint> questsToValidId;
    private Vector<uint> questsToStartId;
    private FuncTree _questsToValidIdtree;
    private FuncTree _questsToStartIdtree;


    public int getTypeId() {
         return 384;
    }

    public GameRolePlayNpcQuestFlag initGameRolePlayNpcQuestFlag(Vector<uint> param1,Vector<uint>  param2) {
         this.questsToValidId = param1;
         this.questsToStartId = param2;
         return this;
    }

    public void reset() {
         this.questsToValidId = new Vector.<uint>();
         this.questsToStartId = new Vector.<uint>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayNpcQuestFlag(param1);
    }

    public void serializeAs_GameRolePlayNpcQuestFlag(ICustomDataOutput param1) {
         param1.writeShort(this.questsToValidId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.questsToValidId.length)
         {
            if(this.questsToValidId[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.questsToValidId[_loc2_] + ") on element 1 (starting at 1) of questsToValidId.");
            }
            param1.writeVarShort(this.questsToValidId[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.questsToStartId.length);
         int _loc3_ = 0;
         while(_loc3_ < this.questsToStartId.length)
         {
            if(this.questsToStartId[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.questsToStartId[_loc3_] + ") on element 2 (starting at 1) of questsToStartId.");
            }
            param1.writeVarShort(this.questsToStartId[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayNpcQuestFlag(param1);
    }

    public void deserializeAs_GameRolePlayNpcQuestFlag(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of questsToValidId.");
            }
            this.questsToValidId.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhShort();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of questsToStartId.");
            }
            this.questsToStartId.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayNpcQuestFlag(param1);
    }

    public void deserializeAsyncAs_GameRolePlayNpcQuestFlag(FuncTree param1) {
         this._questsToValidIdtree = param1.addChild(this._questsToValidIdtreeFunc);
         this._questsToStartIdtree = param1.addChild(this._questsToStartIdtreeFunc);
    }

    private void _questsToValidIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._questsToValidIdtree.addChild(this._questsToValidIdFunc);
            _loc3_++;
         }
    }

    private void _questsToValidIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of questsToValidId.");
         }
         this.questsToValidId.push(_loc2_);
    }

    private void _questsToStartIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._questsToStartIdtree.addChild(this._questsToStartIdFunc);
            _loc3_++;
         }
    }

    private void _questsToStartIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of questsToStartId.");
         }
         this.questsToStartId.push(_loc2_);
    }

}