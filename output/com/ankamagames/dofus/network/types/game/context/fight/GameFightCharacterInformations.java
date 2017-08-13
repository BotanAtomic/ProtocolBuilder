package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorAlignmentInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightCharacterInformations extends GameFightFighterNamedInformations implements INetworkType {

    private int protocolId = 46;
    private int level = 0;
    private ActorAlignmentInformations alignmentInfos;
    private int breed = 0;
    private boolean sex = false;
    private FuncTree _alignmentInfostree;


    public int getTypeId() {
         return 46;
    }

    public GameFightCharacterInformations initGameFightCharacterInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector<uint>  param8,String  param9,PlayerStatus  param10,int  param11,ActorAlignmentInformations  param12,int  param13,boolean  param14) {
         super.initGameFightFighterNamedInformations(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10);
         this.level = param11;
         this.alignmentInfos = param12;
         this.breed = param13;
         this.sex = param14;
         return this;
    }

    public void reset() {
         super.reset();
         this.level = 0;
         this.alignmentInfos = new ActorAlignmentInformations();
         this.sex = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightCharacterInformations(param1);
    }

    public void serializeAs_GameFightCharacterInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterNamedInformations(param1);
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         this.alignmentInfos.serializeAs_ActorAlignmentInformations(param1);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightCharacterInformations(param1);
    }

    public void deserializeAs_GameFightCharacterInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._levelFunc(param1);
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightCharacterInformations(param1);
    }

    public void deserializeAsyncAs_GameFightCharacterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._levelFunc);
         this._alignmentInfostree = param1.addChild(this._alignmentInfostreeFunc);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GameFightCharacterInformations.level.");
         }
    }

    private void _alignmentInfostreeFunc(ICustomDataInput param1) {
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserializeAsync(this._alignmentInfostree);
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

}