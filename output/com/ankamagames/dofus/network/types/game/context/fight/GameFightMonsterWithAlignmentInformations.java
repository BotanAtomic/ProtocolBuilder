package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorAlignmentInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightMonsterWithAlignmentInformations extends GameFightMonsterInformations implements INetworkType {

    private int protocolId = 203;
    private ActorAlignmentInformations alignmentInfos;
    private FuncTree _alignmentInfostree;


    public int getTypeId() {
         return 203;
    }

    public GameFightMonsterWithAlignmentInformations initGameFightMonsterWithAlignmentInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector<uint>  param8,int  param9,int  param10,ActorAlignmentInformations  param11) {
         super.initGameFightMonsterInformations(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10);
         this.alignmentInfos = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.alignmentInfos = new ActorAlignmentInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightMonsterWithAlignmentInformations(param1);
    }

    public void serializeAs_GameFightMonsterWithAlignmentInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightMonsterInformations(param1);
         this.alignmentInfos.serializeAs_ActorAlignmentInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightMonsterWithAlignmentInformations(param1);
    }

    public void deserializeAs_GameFightMonsterWithAlignmentInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightMonsterWithAlignmentInformations(param1);
    }

    public void deserializeAsyncAs_GameFightMonsterWithAlignmentInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._alignmentInfostree = param1.addChild(this._alignmentInfostreeFunc);
    }

    private void _alignmentInfostreeFunc(ICustomDataInput param1) {
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserializeAsync(this._alignmentInfostree);
    }

}