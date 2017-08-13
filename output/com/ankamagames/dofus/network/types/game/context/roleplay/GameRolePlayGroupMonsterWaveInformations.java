package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayGroupMonsterWaveInformations extends GameRolePlayGroupMonsterInformations implements INetworkType {

    private int protocolId = 464;
    private int nbWaves = 0;
    private Vector<GroupMonsterStaticInformations> alternatives;
    private FuncTree _alternativestree;


    public int getTypeId() {
         return 464;
    }

    public GameRolePlayGroupMonsterWaveInformations initGameRolePlayGroupMonsterWaveInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,GroupMonsterStaticInformations  param4,Number  param5,int  param6,int  param7,int  param8,boolean  param9,boolean  param10,boolean  param11,int  param12,Vector<GroupMonsterStaticInformations>  param13) {
         super.initGameRolePlayGroupMonsterInformations(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11);
         this.nbWaves = param12;
         this.alternatives = param13;
         return this;
    }

    public void reset() {
         super.reset();
         this.nbWaves = 0;
         this.alternatives = new Vector.<GroupMonsterStaticInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayGroupMonsterWaveInformations(param1);
    }

    public void serializeAs_GameRolePlayGroupMonsterWaveInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayGroupMonsterInformations(param1);
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
         }
         param1.writeByte(this.nbWaves);
         param1.writeShort(this.alternatives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alternatives.length)
         {
            param1.writeShort((this.alternatives[_loc2_] as GroupMonsterStaticInformations).getTypeId());
            (this.alternatives[_loc2_] as GroupMonsterStaticInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayGroupMonsterWaveInformations(param1);
    }

    public void deserializeAs_GameRolePlayGroupMonsterWaveInformations(ICustomDataInput param1) {
         int _loc4_ = 0;
         GroupMonsterStaticInformations _loc5_ = null;
         super.deserialize(param1);
         this._nbWavesFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.alternatives.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayGroupMonsterWaveInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayGroupMonsterWaveInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nbWavesFunc);
         this._alternativestree = param1.addChild(this._alternativestreeFunc);
    }

    private void _nbWavesFunc(ICustomDataInput param1) {
         this.nbWaves = param1.readByte();
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element of GameRolePlayGroupMonsterWaveInformations.nbWaves.");
         }
    }

    private void _alternativestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._alternativestree.addChild(this._alternativesFunc);
            _loc3_++;
         }
    }

    private void _alternativesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GroupMonsterStaticInformations _loc3_ = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.alternatives.push(_loc3_);
    }

}